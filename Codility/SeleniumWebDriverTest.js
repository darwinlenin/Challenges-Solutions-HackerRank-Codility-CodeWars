"use strict"
const {Builder, By, key, util} = require("selenium-webdriver");
var driver = new Builder().forBrowser('firefox').build();

(async function payevertest() {
    await driver.get('https://commerceos.staging.devpayever.com/');

    setTimeout(()=>{
        let form = driver.findElement(By.tagName('form'));
        let element2 = form.findElement(By.xpath('//*[@id="mat-input-2"]'));
        element2.sendKeys('aqa@payever.org');
        let element3 = form.findElement(By.xpath('//*[@id="mat-input-3"]'));
        element3.sendKeys('Aqacool123!');
        form.submit();
        setTimeout(()=>{
            let buttonLogin = form.findElement(By.className('mat-button-block mat-raised-button'));
            buttonLogin.click();
        },1000);
        setTimeout(()=>{
            let cardWrapper =driver.findElement(By.className('mat-card-logo-wrapper'));
            cardWrapper.click();
            setTimeout(()=> {
                let appButtonClick =driver.findElement(By.className('mat-button mat-button-link mat-button-bold mobile-icons-only desktop-text-only ng-star-inserted'));
                appButtonClick.click();
                setTimeout(()=> {
                    let appButtonClick =driver.findElement(By.xpath('//div[2]/span/business-layout/apps-layout/div/div/app-card/div/mat-card/div[1]/business-applications/div[7]/div[1]/div'));
                    appButtonClick.click();
                    setTimeout(()=> {
                        let themeButtonClick =driver.findElement(By.xpath('//platform-header-component/pe-platform-header/pe-navbar/mat-toolbar/div[1]/button[3]/span/span'));
                        themeButtonClick.click();
                        setTimeout(()=> {
                            let themeCreateButtonClick =driver.findElement(By.xpath('//div[2]/div/app-builder/pe-builder-themes-list/div[2]/pe-builder-themes-list-user/div/pe-builder-theme-plus'));
                            themeCreateButtonClick.click();
                            setTimeout(()=> {
                                let textCreateButtonClick =driver.findElement(By.xpath('//div[2]/div/app-builder/pe-builder-theme/pe-editor/div[1]/pe-builder-navbar-top/mat-toolbar/mat-toolbar-row/pe-builder-navbar-top-button[4]/button/span'));
                                textCreateButtonClick.click();

                                setTimeout(()=> {
                                    driver.executeScript("return document.querySelector('#content > div.canvas-container > pe-editor-canvas').shadowRoot.querySelector('div > div > pe-builder-elements-document > pe-builder-elements-section:nth-child(2) > pe-builder-elements-text.pe-builder-elements-text.ng-star-inserted.active > div').innerText='This test is completed!';");

                                    setTimeout(()=> {
                                        let closeButton =driver.findElement(By.xpath('//platform-header-component/pe-platform-header/pe-navbar/mat-toolbar/div[3]/button'));
                                        closeButton.click();
                                    },5000);
                                },3000);
                            },7000);
                        },7000);
                    },7000);
                },7000);
            },9000);
        },9000);
    },5000);
})();
