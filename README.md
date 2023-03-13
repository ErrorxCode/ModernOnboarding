
# Modern onboarding library

<p align="left">
  <a href="#"><img alt="Android OS" src="https://img.shields.io/badge/OS-Android-3DDC84?style=flat-square&logo=android"></a>
  <a href="#"><img alt="Languages-Java" src="https://img.shields.io/badge/Language-Java-1DA1F2?style=flat-square&logo=java"></a>
  <a href="#"><img alt="verison" src="https://jitpack.io/v/ErrorxCode/ModernOnboarding.svg"></a>
  <a href="https://www.instagram.com/x__coder__x/"><img alt="Instagram - x0.rahil" src="https://img.shields.io/badge/Instagram-x0.rahil-lightgrey"></a>
  <a href="#"><img alt="GitHub Repo stars" src="https://img.shields.io/github/stars/ErrorxCode/ModernOnboarding?style=social"></a>
  </p>


![thumbmail](/thumbnail.png)


## Implimentation

In your project ```build.gradle``` (root of project)

```groovy
 allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
In your module ```build.gradle``` (usually in app)
```groovy
dependencies {
	        implementation 'com.github.ErrorxCode:ModernOnboarding:v1.5'
	}
```

  
## Usage
***Also Compatible Androidx***


Create a list of `OnBoardingPage` passing an image, a title and a description as an argument.
```java
List<OnBoardingPage> pages = new ArrayList<>();
pages.add(new OnBoardingPage(R.drawable.image1,"Title for page 1 goes here....","Description for page 1 goes here...."));
pages.add(new OnBoardingPage(R.drawable.image2,"Title for page 2 goes here....","Description for page 2 goes here...."));
pages.add(new OnBoardingPage(R.drawable.image3,"Title for page 3 goes here....","Description for page 3 goes here...."));
```
**Note : You must have minimum of 3 pages & maximum of 6.**



You can also use its second constructor, which also takes `bgColor, txtColor` as an argument, if you want to customise the page.
```java
new OnBoardingPage(R.drawable.sound_wave, Color.BLACK,Color.WHITE,"title here..","description here...");
```



Finally, pass that list to `OnBoarder.setupOnBoarding()`. You can also pass null as 3rd argument.
```java
OnBoarder.setupOnBoarding(this, pages, new OnFinishLastPage() {
            @Override
            public void onNext() {
                // this is called when user click finish button on last page.
            }
        });
```
You don't neet to do anything else. just put this code in your launching activity and the library will automatically start the onboarding screen when user opens the app **for the first time**

**Full example**

Main activity (Launching activity) :
```java
public class OnBoardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main)  ---> Remove this line
        List<OnBoardingPage> pages = new ArrayList<>();
        pages.add(new OnBoardingPage(R.drawable.image1,"Title for page 1 goes here....","Description for page 1 goes here...."));
        pages.add(new OnBoardingPage(R.drawable.image2,"Title for page 2 goes here....","Description for page 2 goes here...."));
        pages.add(new OnBoardingPage(R.drawable.image3,"Title for page 3 goes here....","Description for page 3 goes here...."));
        
        OnBoarder.setupOnBoarding(this, pages, new OnFinishLastPage() {
            @Override
            public void onNext() {
                // this is called when user click finish button on last page.
            }
    }
}
```


## Suport us
Support me to keep this library alive. If you like my hard work, please give this repo a star 🌟 & Nothing else. Also check my other repos. Thank you ! .


## Powered by 💓
#### Clorabase
>  A account-less platform as a service for android apps. (PaaS)
