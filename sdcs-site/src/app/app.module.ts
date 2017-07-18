import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { ColorPickerModule } from 'ngx-color-picker';

// Routes
import { APP_ROUTES } from './app.routes';

// Directives
import { ReplaceTagDirective } from './directives/replace-tag.directive';

// Services
import { HomeService, ChannelService, DeviceService, Requester } from './services/';

// Components
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ChannelComponent } from './channel/channel/channel.component';
import { DeviceComponent } from './device/device.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ChannelComponent,
    ReplaceTagDirective,
    DeviceComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    ReactiveFormsModule,
    FormsModule,
    ColorPickerModule,
    RouterModule.forRoot(APP_ROUTES)
  ],
  providers: [HomeService, ChannelService, DeviceService, Requester],
  bootstrap: [AppComponent]
})
export class AppModule { }
