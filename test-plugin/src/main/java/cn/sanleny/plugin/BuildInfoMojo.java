package cn.sanleny.plugin;

import org.apache.maven.model.Build;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo( name = "buildinfo")
/*表示该Mojo对应的goal的名字为buildinfo（在调用该goal时需要给出它的名字）*/
public class BuildInfoMojo extends AbstractMojo {

    /*MavenProject的引用，当客户方在执行该插件时，这里的project字段便表示客户工程
    这里我们并没有对project进行初始化，${project}即表示当前的客户工程，
    Maven在运行时会通过依赖注入自动将客户工程对象赋给project字段（请参考Maven自己的IoC容器Plexus）
    */
    @Parameter(defaultValue="${project}")
    private MavenProject project;

    /*该字段表示对输出的各行加上prefix前缀字符串，默认为“+++”*/
    @Parameter(defaultValue="${prefix}")
    private String prefix="+++";

    public void execute() throws MojoExecutionException {
        Build build = project.getBuild();
        String outputDirectory = build.getOutputDirectory();
        String sourceDirectory = build.getSourceDirectory();
        String testOutputDirectory = build.getTestOutputDirectory();
        String testSourceDirectory = build.getTestSourceDirectory();
        getLog().info("==========================\nProject build info:");
        String[] info = {outputDirectory, sourceDirectory, testOutputDirectory, testSourceDirectory};
        for (String item : info) {
            getLog().info("\t" + prefix + "   " + item);
        }
        getLog().info("=======================");
    }
}