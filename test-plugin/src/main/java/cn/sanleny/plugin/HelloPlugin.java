package cn.sanleny.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * @Author: sanleny
 * @Date: 2019-03-04
 * @Description: cn.sanleny.plugin
 * @Version: 1.0
 */
@Mojo( name = "helloPlugin")
/*表示该Mojo对应的goal的名字为helloPlugin（在调用该goal时需要给出它的名字）*/
public class HelloPlugin extends AbstractMojo {

    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info( "Hello plugin______________________" );
    }

}
