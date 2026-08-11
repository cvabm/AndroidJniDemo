# AndroidJniDemo

Kotlin + JNI 示例：通过 C++ 调用 `stringFromJNI` / `encodeToBase64`（Base64）。

## 要求

- JDK 17
- Android SDK 33、CMake 3.22、NDK

## 构建

```bash
./gradlew assembleDebug    # Debug
./gradlew assembleRelease  # 已签名 Release APK
```

产物：`app/build/outputs/apk/release/app-release.apk`

## CI

GitHub Actions（`.github/workflows/android-release.yml`）在 push/PR 时编译 Release 并上传 Artifact；打 `v*` tag 时发布 GitHub Release。

## 签名（仅 Demo）

仓库内 `release.keystore`，密码/别名均为 `androidjnidemo`。**勿用于上架。**
