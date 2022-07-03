# poc-quickjs

Extracted from https://github.com/seven332/quickjs-android with trivial modifications. This was a quick test to
determine if I could get the library to work on the JVM, not Android. It worked. The only change to the source code was
commenting-out of some Android-specific annotations.

To run, you'll need to first compile quickjs, using the original repo. Here's what worked for me:

1. Checkout https://github.com/seven332/quickjs-android w/submodules

2. Modify ~/quickjs-android/library/CMakeLists.txt to fix the include paths. For me, that meant adding the following:

```
include_directories(/Library/Java/JavaVirtualMachines/openjdk11-temurin/Contents/Home/include/
/Library/Java/JavaVirtualMachines/openjdk11-temurin/Contents/Home/include/darwin)
```

3. Run Cmake, then compile, then copy libquickjs-android.dylib to ~/Library/Java/Extensions

With that, this repo should now work. There is one simple test that runs some JavaScript code.

To make this QuickJS wrapper properly useful, one would need to build the native code for several platforms and bundle
them in a JAR.

There was also a quickjs-android project from Square, but was abandoned. The source code is available here:
https://github.com/cashapp/zipline/tree/0.9.2 They apparently first compile JavaScript to bytecode then evaluate it,
which is presumably faster. The C++ JNIS code is preserved in this repo, see `square-quickjs-jni.cpp`.