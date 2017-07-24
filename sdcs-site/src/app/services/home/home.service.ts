import { Injectable } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Requester } from './../requester';

@Injectable()
export class HomeService {

  constructor(private requester: Requester) { }

  getAllDevices(): Observable<any> {
    return this.requester.get('');
  }

  getDeviceById(deviceId): Observable<any> {
    return this.requester.get(deviceId);
  }
}
