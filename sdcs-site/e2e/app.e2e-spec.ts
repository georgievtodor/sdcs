import { SdcsSitePage } from './app.po';

describe('sdcs-site App', () => {
  let page: SdcsSitePage;

  beforeEach(() => {
    page = new SdcsSitePage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
