import { Observable } from 'rxjs/observable';
import { Requester } from './../../services/requester';
import { ColorPickerModule } from 'ngx-color-picker';
import { ChannelService } from './../../services/channel/channel.service';
import { FormBuilder, ReactiveFormsModule, FormsModule, NgForm } from '@angular/forms';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';


import { ChannelComponent } from './channel.component';

describe('ChannelComponent', () => {
  let component: ChannelComponent;
  let componentServiceStub = {
    updateCommand: (command, id) => {
      return {
        subscribe: (command, id) => {
          return command;
        }
      }
    }
  };
  let channelMock = { channelType: 'VolumeChannel', command: { val: '50' }, id: 3 };

  let urlFormMock = { value: { newUrl: 'https://test.bg' } } as NgForm;

  let fixture: ComponentFixture<ChannelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ChannelComponent],
      providers: [
        { provide: ChannelService, useValue: componentServiceStub },
        FormBuilder
      ],
      imports: [
        ReactiveFormsModule,
        ColorPickerModule,
        FormsModule
      ],
      schemas: [ NO_ERRORS_SCHEMA ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChannelComponent);
    component = fixture.componentInstance;
    component.channel = channelMock;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeDefined();
  });

  it('expect onRangeChange(event) to set appropriate value', () => {
    let event = { target: { value: 5 } }
    component.onRangeChange(event);
    expect(component.channel.command.val).toBe(5);
  })

  it('expect onRangeMove(event) to set appropriate value', () => {
    let event = { target: { value: 5 } }
    component.onRangeMove(event);
    expect(component.channel.command.val).toBe(5);
  })

  it('expect onTriggerClicked(event) to set appropriate value', () => {
    component.channel = {  channelType: 'VolumeChannel', command: '', id: 3 }
    let command = 'Play';
    component.onTriggerClicked(command);
    expect(component.channel.command).toBe('Play')
  })
});
