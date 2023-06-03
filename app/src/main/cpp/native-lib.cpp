#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_toantx_mycppproject_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_toantx_mycppproject_MainActivity_process(
        JNIEnv *env,
        jobject mainActivityInstance) {
    jclass cls_main = env->GetObjectClass(mainActivityInstance);

    jmethodID methodId = env->GetMethodID(cls_main, "processInJava", "()Ljava/lang/String;");
    jstring result = static_cast<jstring>(env->CallObjectMethod(mainActivityInstance, methodId));
    return result;
}