import { NO_ERRORS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { HomeService } from './../services/home/home.service';

import { HomeComponent } from './home.component';

describe('HomeComponent', () => {
  let component: HomeComponent;
  let fixture: ComponentFixture<HomeComponent>;
  let deviceStub = {
    label: 'testLabel',
    manufacturer: 'testManufacturer'
  },
  devicesStub = [deviceStub];

  let componentServiceStub = {
    getAllDevices: () => {
      return {
        subscribe: (r) => {
          return r(devicesStub);
        }
      }
    },
    getDeviceById: (deviceId) => {
      return {
        subscribe: (r) => {
          return r(deviceStub);
        }
      }
    }
  }

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [HomeComponent],
      providers: [
        { provide: HomeService, useValue: componentServiceStub }
      ],
      schemas: [NO_ERRORS_SCHEMA]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });

  it('when ngOnInit() is called should set correct devices', () => {
    expect(component.devices).toBe(devicesStub);
  })

  it('when onDeviceSelected(deviceId) is called should set correct device', () => {
    component.onDeviceSelected(1);
    expect(component.device).toBe(deviceStub);
  })
});
