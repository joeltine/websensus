java_library(
    name = "frontend",
    srcs = glob(["*.java"]),
)

java_binary(
    name = "server",
    srcs = ["MainServer.java"],
    main_class = "com.websensus.frontend.MainServer",
    deps = [":frontend"],
)
