import { Component, OnInit, Input } from '@angular/core';
import { NgForm, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ChannelService } from './../../services/channel/channel.service';

@Component({
  selector: 'app-channel',
  templateUrl: './channel.component.html',
  styleUrls: ['./channel.component.css']
})
export class ChannelComponent implements OnInit {
  @Input() channel: any;

  public editable: boolean = false;
  public updateForm: FormGroup;

  constructor(private service: ChannelService, private fb: FormBuilder) { }

  ngOnInit() {
    this.updateForm = this.fb.group({
      label: ['']
    })

    if (this.channel.channelType == 'HumidityChannel' || this.channel.channelType == 'TemperatureChannel') {
      setInterval(this.checkIfCommandIsUpdated.bind(this), 2000);
    }
  }

  public checkIfCommandIsUpdated() {
    return this.service.checkIfCommandIsUpdated(this.channel.id).subscribe(r => {
      if (this.channel.command.val != r) {
        this.channel.command.val = r;
      }
    })
  }

  public onRangeChange(event) {
    this.channel.command.val = event.target.value;

    const id = this.channel.id,
      channelType = this.channel.channelType;

    return this.service.updateCommand(event.target.value, id, channelType)
      .subscribe();
  }

  public onRangeMove(event) {
    this.channel.command.val = event.target.value;
  }

  onUrlUpdate(urlForm: NgForm) {
    const newUrl = urlForm.value.newUrl,
      id = this.channel.id,
      channelType = this.channel.channelType;

    return this.service.updateCommand(newUrl, id, channelType)
      .subscribe();
  }

  onTriggerClicked(command) {

    this.service.updateCommand(command, this.channel.id, this.channel.channelType)
      .subscribe(r => {
      });

    this.channel.command = command;
  }

  onChangeColor(color: string) {
    return this.service.updateCommand(color, this.channel.id, this.channel.channelType)
      .subscribe();
  }

  public editClicked() {
    this.updateForm.setValue({
      label: ''
    })

    this.editable = !this.editable;
  }

  public onUpdateChannel(): void {
    const label = this.updateForm.value['label'].trim() || this.channel.label;
    if (label != this.channel.label) {
      this.service.updateLabel(label, this.channel.id, this.channel.channelType).subscribe(r => {
      });
    }

    this.channel.label = label;
    this.editable = false;

  }


}
