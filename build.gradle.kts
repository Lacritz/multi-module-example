plugins {
    kotlin("jvm") version "1.4.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

subprojects {
    version = "2020.01-SNAPSHOT"

    repositories {
        mavenCentral()
        mavenLocal()
        /*
         * Necessary due to the `org.restlet.jee` dependencies,
         * which are necessary to run a embedded solr for tests
         */
        jcenter()
    }
}

fun getArchiveName(project: Project): String {
    var archiveName = project.name
    var parent = project.parent
    while (parent != null) {
        archiveName = "${parent.name}-${archiveName}"
        parent = parent.parent
    }
    return archiveName
}

tasks.create<Task>("modules") {
    print(this.project)
    this.outputs.upToDateWhen { false }
}

fun print(project: Project) {
    project.childProjects.values.forEach { print(it) }
    println("${project.group}:${project.name}:${project.version}")
    logger.info("${project.group}:${project.name}:${project.version}")
}
