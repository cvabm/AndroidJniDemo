#include <jni.h>
#include <string>
#include <android/log.h>
#include "base64.h"

extern "C" JNIEXPORT jstring
Java_com_example_androidjnidemo_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    __android_log_print(ANDROID_LOG_DEBUG, "MyAppTag", "This is a debug message");
    __android_log_print(ANDROID_LOG_ERROR, "MyAppTag", "This is an error message");
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring
Java_com_example_androidjnidemo_MainActivity_encodeToBase64(JNIEnv *env, jobject thiz, jstring input) {
    const char *inputStr = env->GetStringUTFChars(input, 0);
    std::string encoded = base64_encode(reinterpret_cast<const unsigned char *>(inputStr),
                                        strlen(inputStr));
    env->ReleaseStringUTFChars(input, inputStr);
    return env->NewStringUTF(encoded.c_str());
}

