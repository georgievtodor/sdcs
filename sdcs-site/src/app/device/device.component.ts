import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { DeviceService } from './../services/device/device.service';

@Component({
  selector: 'app-device',
  templateUrl: './device.component.html',
  styleUrls: ['./device.component.css']
})
export class DeviceComponent implements OnInit {
  @Input() public device: any;

  public updateForm: FormGroup;

  constructor(private service: DeviceService, private fb: FormBuilder) { }

  ngOnInit() {
    this.updateForm = this.fb.group({
      label: [''],
      firmwareVersion: [''],
      hardwareVersion: ['']
    })
  }

  public editClicked() {
    this.updateForm.setValue({
      label: '',
      firmwareVersion: '',
      hardwareVersion: ''
    })

    this.device.editable = !this.device.editable;
  }

  public onUpdateDevice(): void {
    const label = this.updateForm.value['label'].trim() || this.device.label;
    const firmwareVersion = this.updateForm.value['firmwareVersion'].trim() || this.device.firmwareVersion;
    const hardwareVersion = this.updateForm.value['hardwareVersion'].trim() || this.device.hardwareVersion;

    if (this.device.label != label || this.device.firmwareVersion != firmwareVersion || this.device.hardwareVersion != hardwareVersion) {
      this.service.updateDevice(label, firmwareVersion, hardwareVersion, this.device.id)
        .subscribe(r => {
          if (r == "success") {
            this.device.label = label;
            this.device.firmwareVersion = firmwareVersion;
            this.device.hardwareVersion = hardwareVersion;
          }
        });
    }

    this.device.editable = false;

  }


}
