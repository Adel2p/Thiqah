# Android Kotlin MVP : Sample App
please note that I apologize for not completing the task because of Family reasons
This repository contains a detailed sample app that implements MVP architecture in Kotlin using Dagger2, Room, RxJava, FastAndroidNetworking, PlaceHolderView and AndroidDebugDatabase
# Architecture Blueprint
![Blueprint](https://janishar.github.io/images/mvp-app-pics/mvp-interactor-arch.png)
<br>

# Project Structure
![Structure](https://janishar.github.io/images/mvp-app-pics/mvp-interactor-project-structure.png)
<br>

# Read the below listed articles. They describe the MVP concepts and the Project structure.
1. [MVP: Part 1](https://blog.mindorks.com/essential-guide-for-designing-your-android-app-architecture-mvp-part-1-74efaf1cda40#.lkml1yggq)
2. [MVP: Part 2](https://blog.mindorks.com/essential-guide-for-designing-your-android-app-architecture-mvp-part-2-b2ac6f3f9637#.dge0wl8rl)
3. [MVP: Part 3](https://blog.mindorks.com/essential-guide-for-designing-your-android-app-architecture-mvp-part-3-dialog-viewpager-and-7bdfab86aabb)
4. [Extension with Interactors and Repositories](https://blog.mindorks.com/android-mvp-architecture-extension-with-interactors-and-repositories-bd4b51972339)

#### The app has following packages:
1. **data**: It contains all the data accessing and manipulating components.
2. **di**: Dependency providing classes using Dagger2.
3. **ui**: View classes along with their corresponding Presenters.
4. **utils**: Utility classes.

#### Classes have been designed in such a way that it could be inherited and maximize the code reuse.

### Library reference resources:
1. RxJava2: https://github.com/amitshekhariitbhu/RxJava2-Android-Samples
2. Dagger2: https://github.com/MindorksOpenSource/android-dagger2-example
3. FastAndroidNetworking: https://github.com/amitshekhariitbhu/Fast-Android-Networking
4. PlaceHolderView: https://github.com/janishar/PlaceHolderView
5. AndroidDebugDatabase: https://github.com/amitshekhariitbhu/Android-Debug-Database
6. Calligraphy: https://github.com/chrisjenx/Calligraphy
7. Room: https://developer.android.com/topic/libraries/architecture/room.html
8. ButterKnife: http://jakewharton.github.io/butterknife/

### Concept reference resources:
1. [Introduction to Dagger 2: Part 1](https://blog.mindorks.com/introduction-to-dagger-2-using-dependency-injection-in-android-part-1-223289c2a01b#.ki6nt86l6)
2. [Introduction to Dagger 2: Part 2](https://blog.mindorks.com/introduction-to-dagger-2-using-dependency-injection-in-android-part-2-b55857911bcd#.mkpzyk8sa)
3. [Android Dagger2: Critical things to know before you implement](https://blog.mindorks.com/android-dagger2-critical-things-to-know-before-you-implement-275663aecc3e#.bskiz1879)
4. [The Best Android Networking Library for Fast and Easy Networking](https://blog.mindorks.com/simple-and-fast-android-networking-19ed860d1455#.cyzrve85o)
5. [RxJava + Fast Android Networking](https://blog.mindorks.com/rxjava-fast-android-networking-6e3d90ee4387#.7hjoex22m)
6. [Migrating from RxJava 1.0 to RxJava 2.0 and Learn RxJava by Examples](https://blog.mindorks.com/migrating-from-rxjava1-to-rxjava2-5dac0a94b4aa#.3lg46kora)
7. [Android Tinder Swipe View Example](https://blog.mindorks.com/android-tinder-swipe-view-example-3eca9b0d4794#.u7i7jbbvy)
8. [Debugging Android Databases And Shared Preferences In The Easiest Way](https://blog.mindorks.com/debugging-android-databases-and-shared-preferences-in-the-easiest-way-e5f705dfc06b#.pxw0hvnws)
9. [RxJava Anatomy: What is RxJava, how RxJava is designed, and how RxJava works.](https://blog.mindorks.com/rxjava-anatomy-what-is-rxjava-how-rxjava-is-designed-and-how-rxjava-works-d357b3aca586)

All pull requests are welcome, make sure to follow the [contribution guidelines](CONTRIBUTING.md)
when you submit pull request.
