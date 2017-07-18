import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Requester } from './../requester';

@Injectable()
export class DeviceService {

  constructor(private requester: Requester) { }

  public updateDevice(label, firmwareVersion, hardwareVersion, deviceId) {
    const body = {
      label,
      firmwareVersion,
      hardwareVersion
    }

    return this.requester.put(`${deviceId}`, body);
  }

}
