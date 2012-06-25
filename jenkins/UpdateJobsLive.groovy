// Run this in the groovy console of a running Jenkins instance
// If you manually change xml config files of Jenkins jobs,
// this will force Jenkins to reload all the config from the disk to memory.
// There might be a better way to do this... but I don't know how :)
def projectName = 'Commit_master'
def file = new File("/jenkins/jobs/"+projectName);
def project = Items.load(Jenkins.getInstance(), file);
def jenkins = Jenkins.getInstance();
def field = Jenkins.class.getDeclaredField("items");
field.setAccessible(true)
def items = field.get(jenkins)

items.put(project.name, project);