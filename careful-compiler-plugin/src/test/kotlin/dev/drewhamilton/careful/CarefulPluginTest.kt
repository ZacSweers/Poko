package dev.drewhamilton.careful

import com.google.common.truth.Truth.assertThat
import com.tschuchort.compiletesting.KotlinCompilation
import com.tschuchort.compiletesting.SourceFile
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.JvmTarget
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

class CarefulPluginTest {

    @JvmField
    @Rule var temporaryFolder: TemporaryFolder = TemporaryFolder()

    @Test fun `compilation succeeds`() {
        val carefulClassFile = SourceFile.kotlin(
            "CarefulClass.kt",
            """
                package dev.drewhamilton.careful

                import dev.drewhamilton.careful.Careful

                @Careful class CarefulClass(
                    val string: String
                )
            """.trimIndent()
        )
        val result = prepareCompilation(carefulClassFile).apply {
            verbose = true
        }.compile()

        assertThat(result.exitCode).isEqualTo(KotlinCompilation.ExitCode.OK)
    }

    private fun compile(vararg sourceFiles: SourceFile): KotlinCompilation.Result {
        return prepareCompilation(*sourceFiles).compile()
    }

    private fun prepareCompilation(vararg sourceFiles: SourceFile) = KotlinCompilation().apply {
        workingDir = temporaryFolder.root
        compilerPlugins = listOf<ComponentRegistrar>(CarefulComponentRegistrar())
        inheritClassPath = true
        sources = sourceFiles.asList()
        verbose = false
        jvmTarget = JvmTarget.fromString("1.8")!!.description
    }
}
