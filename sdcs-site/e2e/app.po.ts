import { browser, by, element, Key, Button } from 'protractor';

export class SdcsSitePage {
  navigateTo() {  
    browser.driver.get('localhost:4200/');
  }

  wait() {
    browser.waitForAngular();
  }

  getTitle() {
    return browser.getTitle();
  }

  getDevices() {
    return element.all(by.css('.device'));
  }

  getFirstDevice() {
    return element(by.css('.device'));
  }

  sendClick() {
    browser.actions().click(Button.LEFT).perform();
  }

  pause() {
    browser.pause();
  }

  getElementByCss(css) {
    return element(by.css(css));
  }

  getDeviceInfo() {
    return element(by.css('.device-info'));
  }

  getDeviceInfoEditButton() {
    return element(by.css('.btn'));
  }

  getEditableDevice() {
    return element(by.css('.editable'));
  }

  getNotEditableDevice() {
    return element(by.css('.not-editable'));
  }

  getLabelInputField() {
    return element(by.css('#device-label'));
  }

  getLabelH3() {
    return element(by.css('.d-label'));
  }

  getVolumeInpit() {
    return element(by.css('#rangeInput'));
  }

  getVolumeInputValue() {
    return element(by.css('.rangeInputTextValue'));
  }

  getSongURL() {
    return element(by.css('#newUrl'));
  }
  getSongURLButton() {
    return element(by.css('.btn-url'));
  }

  getSongControl() {
    return element(by.css('.btn-group .btn'));
  }
  
  hasClass(element, className) {
    return element.getAttribute('class').then((classes) => {
      return classes.split(' ').indexOf(className) !== -1;
    })
  }
}
