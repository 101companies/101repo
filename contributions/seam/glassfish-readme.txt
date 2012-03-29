The GlassFish home directory and domain are set in the build.properties file adjacent to this readme.

First, you must prepare GlassFish for a seam-gen project (i.e., deploy Hibernate as a JPA provider)

  ant gf-prepare

Next, you need to start GlassFish:

  ant gf-start

Finally, you can deploy the project:

  ant gf-explode

GlassFish deployment works out of the box for WAR projects. To deploy an EAR project, make the following changes:

  1. Uncomment the <ejb-local-ref> entries in resources/WEB-INF/web.xml (include additional entries as necessary)
  2. Strip the contents up to and including the # in the element <persistence-unit-name> in resources/WEB-INF/web.xml
  3. Uncomment the <jar-file> element in resources/META-INF/persistence-dev.xml & resources/META-INF/persistence-prod.xml

If you plan to use the default Derby datasource in GlassFish, named jdbc/__default, then uncomment the following property
in the build.properties file at the root of the project to prevent the gf-deploy-datasource target from executing:

  glassfish.datasource.useDefault=true

When switching back and forth between a JBoss AS deployment and a GlassFish deployment, be sure to clean the project:

  ant clean

GlassFish command reference:

gf-start - Starts GlassFish
gf-debug - Starts GlassFish in debug mode
gf-stop - Stops GlassFish
gf-reboot - Restarts GlassFish
gf-deploy-datasource - Deploys the datasource and connection pool to GlassFish
gf-explode - Deploys the exploded archive to GlassFish (restarts application if already deployed)
gf-hotdeploy - Hot deploys Java classes, Seam components, and view resources
gf-reexplode - Cleans, undeploys, and deploys the exploded archive to GlassFish
gf-deploy - Deploys the packaged archive to GlassFish
gf-undeploy - Undeploys the exploded or packaged archive from GlassFish
gf-redeploy - Cleans, undeploys, and deploys the packaged archive to GlassFish
gf-stage - Prepares an exploded archive targeting GlassFish
gf-archive - Prepares a packaged archive targeting GlassFish
gf-prepare - Prepares GlassFish for a seam-gen project deployment (calls gf-deploy-hibernate)
gf-deploy-hibernate - Deploys Hibernate as a JPA provider on GlassFish
