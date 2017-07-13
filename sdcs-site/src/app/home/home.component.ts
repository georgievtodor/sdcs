import { HomeService } from './../services/home.service';
import { Component, OnInit, ViewContainerRef } from '@angular/core';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public devices: any;
  public device: any;

  constructor(private service: HomeService) { }

  ngOnInit() {
    this.service.getAllDevices()
      .subscribe(response => {
        if (response.message !== 'error') {
          this.devices = response;
        }
      });
  }

  public onDeviceSelected(deviceId) {
    this.service.getDeviceById(deviceId)
    .subscribe(response => {
      if (response.message !== 'error') {
        this.device = response;
      }
    });
  }

}
