include(":core")
if (System.getenv("IS_CICD") == null || System.getenv("IS_CICD") == "")
{
    include (":app")
}
