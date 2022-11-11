import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.plugin.use.PluginDependenciesSpec

fun DependencyHandler.projectImplementation(path: String) {
    implementation(project(path))
}

@Suppress(
    "OPT_IN_IS_NOT_ENABLED", // OptIn usage
    "UNCHECKED_CAST" // Collection<*> as Collection<Any>
)
@OptIn(ExperimentalStdlibApi::class) // buildList
// only List or String or platform enters.
fun List<*>.dependenciesFlatten() = buildList {
    this@dependenciesFlatten.forEach { dependency ->
        checkNotNull(dependency) {
            "dependency $dependency is null."
        }
        when (dependency) {
            is Collection<*> -> addAll(dependency as Collection<Any>)
            else -> add(dependency)
        }
    }
}

private fun DependencyHandler.implementation(dependency: Any) {
    add("implementation", dependency)
}

private fun DependencyHandler.debugImplementation(dependency: Any) {
    add("debugImplementation", dependency)
}

private fun DependencyHandler.testImplementation(dependency: Any) {
    add("testImplementation", dependency)
}

private fun DependencyHandler.kapt(dependency: Any) {
    add("kapt", dependency)
}

private fun DependencyHandler.project(path: String) =
    project(mapOf(Pair("path", path))) as ProjectDependency
