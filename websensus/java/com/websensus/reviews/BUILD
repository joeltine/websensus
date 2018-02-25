package_group(
    name = "internal",
    packages = [
        "//websensus/java/com/websensus/reviews/...",
    ],
)

package(default_visibility = ["//websensus/java/com/websensus/reviews:internal"])

java_library(
    name = "reviews",
    srcs = glob(["*.java"]),
    data = [
        "//websensus/java/com/websensus/reviews/data:reviews_electronics.json",
    ],
    deps = [
        "//third_party:guice",
        "//websensus/java/com/websensus/options",
        "@com_google_code_gson//jar",
        "@com_google_guava_guava//jar",
        "@commons_cli//jar",
    ],
)

java_binary(
    name = "review_generator",
    main_class = "com.websensus.reviews.ReviewGenerator",
    jvm_flags = [
        "-Xms2g",
        "-Xmx6g",
    ],
    runtime_deps = [
        ":reviews",
    ],
)
