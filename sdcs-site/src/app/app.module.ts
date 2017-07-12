import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';

// Routes
import { APP_ROUTES } from './app.routes';

// Services
import { HomeService, ChannelService, Requester} from './services/';

// Components
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ChannelComponent } from './channel/channel/channel.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ChannelComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(APP_ROUTES)
  ],
  providers: [HomeService, Requester],
  bootstrap: [AppComponent]
})
export class AppModule { }
