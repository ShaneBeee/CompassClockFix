plugins {
    id("java")
}

// The Minecraft version we're currently building for
val minecraftVersion = "1.21.4"
// Version of ResourcePack
val projectVersion = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
}

tasks {
    register("resourcepack", Zip::class) {
        archiveFileName = "CompassClockFix-${projectVersion}-${minecraftVersion}.zip"
        from("src/main/resources/resource-pack") {
            exclude("**/.DS_Store")
            destinationDirectory = file("build/libs/")
        }
    }
    processResources {
        expand("version" to projectVersion)
        exclude("datapack/*")
        exclude("resource-pack/*")
    }
}
