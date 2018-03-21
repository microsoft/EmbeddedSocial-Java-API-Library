# Microsoft Embedded Social
## Java Library for Server API
This is a library for interacting with the Microsoft Embedded Social API in your Java code.

By using this code, you agree to the [Developer Code of Conduct](DeveloperCodeOfConduct.md), and the [License Terms](LICENSE).

This project has adopted the [Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/). For more information see the [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/) or contact [opencode@microsoft.com](mailto:opencode@microsoft.com) with any additional questions or comments.

### Simple Instructions

The module `test` shows a very simple way to use the library to make calls to Microsoft Embedded Social. The module includes a test example for three types of calls: synchronous, asynchronous, and batched calls. 

Start by looking in test/Main.java. The `test` example only use the GetBuildsCurrent call. This call does not require an authentication header unlike most other calls to Embedded Social. For more documentation on the Microsoft Embedded Social API and its calls (including how to format the authentication header), please see our Swagger page:

https://api.embeddedsocial.microsoft.com/swagger/

