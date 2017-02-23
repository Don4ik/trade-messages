import { Ngapp1Page } from './app.po';

describe('ngapp1 App', function() {
  let page: Ngapp1Page;

  beforeEach(() => {
    page = new Ngapp1Page();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
