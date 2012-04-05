// Run this in the groovy console of a running Jenkins instance
// If you manually change xml config files of Jenkins jobs,
// this will force Jenkins to reload all the config from the disk to memory.
// There might be a better way to do this... but I don't know how :)

def jobs = [
  'JOB_NAMES_HERE'
];

for(String name : jobs) {
  try {
    def instance = hudson.model.Hudson.instance.getItem(name);
    instance.getDescriptor().load();
    instance.getConfigFile().unmarshal(instance).save();
    println("worked for: $instance");
  } catch(Throwable t) {
    println("failed for: $name");
  }
}
