import { SdcsSitePage } from './app.po';

describe('sdcs-site App', () => {
  let page: SdcsSitePage;

  beforeEach(() => {
    page = new SdcsSitePage();
  });

  it('should have a title set to Smart Device Control System', () => {
    // arrange
    page.navigateTo();

    // assert
    expect(page.getTitle()).toBe('Smart Device Control System');
  })

  it('when loading page to load devices', () => {
    // arrange
    page.navigateTo();

    // assert
    expect(page.getDevices()).toBeTruthy();
  })

  it('when clicked on device to load device info ', () => {
    // arrange
    page.navigateTo();
    page.getElementByCss('.device').click();

    // act
    expect(page.getElementByCss('.device-info')).toBeTruthy();
  })

  it('when clicked on device edit button should load editable page', () => {
    // arrange
    page.navigateTo();
    page.getElementByCss('.device').click();
    page.getElementByCss('.btn').click();
    
    // assert
    expect(page.getElementByCss('.editable')).toBeTruthy();
  })

  it('when label is changed to be saved', () => {
    // arrange
    page.navigateTo();
    page.getElementByCss('.device').click();
    let savedLabelValue = page.getElementByCss('.d-label').getText()
    page.getElementByCss('.btn').click();
    let label = page.getElementByCss('#device-label');
    
    // act
    label.sendKeys('testLabel');
    page.getDeviceInfoEditButton().click();

    // assert
    expect(page.getElementByCss('.d-label').getText()).toBe('testLabel');

    // restore
    page.getElementByCss('.btn').click();
    label.sendKeys(savedLabelValue);
    page.getElementByCss('.btn').click();
    
  })

  it('when volume is changed should be saved', () => {
    // arrange
    page.navigateTo();
    page.getElementByCss('.device').click();
    let volumeInput = page.getElementByCss('#rangeInput');

    // act
    volumeInput.click();

    // assert
    expect(page.getElementByCss('.rangeInputTextValue').getText()).toBe('50');
  })
 
    it('when song url is changed should be saved', () => {
      // arrange
      page.navigateTo();
      page.getElementByCss('.device').click();
      let songUrl = page.getElementByCss('#newUrl');
      let saveButton = page.getElementByCss('.btn-url');
      let savedInputValue = songUrl.getAttribute('value');

      // act
      songUrl.clear();
      songUrl.sendKeys('https://www.test.com');
      saveButton.click();

      // assert
      expect(page.getElementByCss('#newUrl').getAttribute('value')).toBe('https://www.test.com');

      // restore
      songUrl.clear();
      songUrl.sendKeys(savedInputValue);
      saveButton.click();
    })

    it('when song control is changed should be saved', () => {
      // arrange
      page.navigateTo();
      page.getElementByCss('.device').click();
      let button = page.getElementByCss('.song-control-play');

      // act
      button.click();

      // assert
      expect(page.hasClass(button, 'locked_active')).toBe(true);
    })

    it('when trigger is changed should be saved', () => {
      // arrange
      page.navigateTo();
      page.getElementByCss('.device').click();
      let button = page.getElementByCss('.trigger-on');

      // act
      button.click();

      // assert
      expect(page.hasClass(button, 'locked_active')).toBe(true);
    })
});
