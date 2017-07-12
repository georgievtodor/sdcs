import { Injectable } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';
import 'rxjs/add/observable/throw';
import { Requester } from './requester';

@Injectable()
export class HomeService {
  api_url = 'http://localhost:8080';

  headers: Headers = new Headers({
    'Content-Type': 'application/json',
    Accept: 'application/json'
  })

  constructor(private requester: Requester) { }

  getAllDevices(): Observable<any> {
    return this.requester.get('');
  }

  getDeviceById(deviceId): Observable<any> {
    return this.requester.get(deviceId);
  }
}
