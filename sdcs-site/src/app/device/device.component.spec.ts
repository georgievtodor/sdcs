import { FormBuilder, ReactiveFormsModule, FormsModule } from '@angular/forms';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { DeviceService } from './../services/device/device.service';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeviceComponent } from './device.component';

describe('DeviceComponent', () => {
  let component: DeviceComponent;
  let fixture: ComponentFixture<DeviceComponent>;
   let componentServiceStub = {
    updateDevice: (label, firmwareVersion, hardwareVersion, deviceId) => {
      return {
        subscribe: (label, firmwareVersion, hardwareVersion, deviceId) => {
          return;
        }
      }
    }
  };

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeviceComponent ],
      providers: [
        { provide: DeviceService, useValue: componentServiceStub },
        FormBuilder
      ],
      imports: [
        ReactiveFormsModule,
        FormsModule
      ],
      schemas: [ NO_ERRORS_SCHEMA ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeviceComponent);
    component = fixture.componentInstance;
    component.device = { channels: [], editable: false, label: 'testLabel', firmwareVersion: 'testFirmwareVersion', hardwareVersion: 'testHardwareVersion' };
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });

  it('when editClicked() is called should change editable value', () => {
    component.editClicked();
    expect(component.device.editable).toBe(true);
  })

  it('when editClicked() is called should set label value to empty string', () => {
    component.editClicked();
    expect(component.updateForm.value['label']).toBe('');
  })

  it('when editClicked() is called should set firmwareVersion value to empty string', () => {
    component.editClicked();
    expect(component.updateForm.value['firmwareVersion']).toBe('');
  })

  it('when editClicked() is called should set hardwareVersion value to empty string', () => {
    component.editClicked();
    expect(component.updateForm.value['hardwareVersion']).toBe('');
  })
});
