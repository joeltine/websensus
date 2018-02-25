java_library(
    name = "reviews",
    srcs = glob(["*.java"]),
    data = [
        "//websensus/java/com/websensus/reviews/data:reviews_electronics.json",
    ],
    deps = [
        "//third_party:guice",
        "@com_google_guava_guava//jar",
        "@commons_cli//jar",
        "@com_google_code_gson//jar",
    ],
)

java_binary(
    name = "review_generator",
    main_class = "com.websensus.reviews.ReviewGenerator",
    runtime_deps = [
        ":reviews",
    ],
)
