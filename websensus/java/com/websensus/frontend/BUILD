java_library(
    name = "frontend",
    srcs = glob([".*java"]),
)

java_binary(
    main_class = "com.websensus.frontend.MainServer",
    name = "server",
    srcs = ["MainServer.java"],
    deps = [":frontend"],
)
