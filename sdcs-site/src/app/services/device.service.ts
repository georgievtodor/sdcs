import { Requester } from './requester';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class DeviceService {

  constructor(private requester: Requester) { }


}
