import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/observable';
import { Requester } from './../requester';

@Injectable()
export class ChannelService {

  constructor(private requester: Requester) { }

  public updateCommand(commandVal, channelId) {
    const body = {
      command: commandVal
    }

    return this.requester.put(`channel/${channelId}`, body);
  }

  public updateLabel(label, channelId) {
    const body = {
      label
    }

    return this.requester.put(`channel/label/${channelId}`, body);
  }

}
