import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/observable';
import { Requester } from './../requester';

@Injectable()
export class ChannelService {

  constructor(private requester: Requester) { }

  public updateCommand(commandVal, channelId, channelType) {
    const body = {
      command: commandVal,
      channelType
    }

    return this.requester.put(`channel/${channelId}`, body);
  }

  public updateLabel(label, channelId, channelType) {
    const body = {
      label,
      channelType
    }

    return this.requester.put(`channel/label/${channelId}`, body);
  }

  public checkIfCommandIsUpdated(channelId): Observable<any> {
    return this.requester.get(`channel/${channelId}`);
  }

}
