// Karma configuration
// http://karma-runner.github.io/0.10/config/configuration-file.html

module.exports = function(config) {
  config.set({
    // base path, that will be used to resolve files and exclude
    basePath: '',

    // testing framework to use (jasmine/mocha/qunit/...)
    frameworks: ['jasmine'],

    // list of files / patterns to load in the browser
    files: [
      'src/main/webapp/WEB-INF/vendor/angular/angular.js',
      'src/main/webapp/WEB-INF/vendor/angular-mocks/angular-mocks.js',
      'src/main/webapp/WEB-INF/vendor/angular-resource/angular-resource.js',
      'src/main/webapp/WEB-INF/vendor/angular-cookies/angular-cookies.js',
      'src/main/webapp/WEB-INF/vendor/angular-sanitize/angular-sanitize.js',
      'src/main/webapp/WEB-INF/vendor/angular-route/angular-route.js',
      'src/main/webapp/WEB-INF/core/*.js',
      'src/main/webapp/WEB-INF/core/**/*.js',
      'src/main/webapp/test/mock/**/*.js',
      'src/main/webapp/test/spec/**/*.js'
    ],

    // list of files / patterns to exclude
    exclude: [],

    // web server port
    port: 8080,

    // level of logging
    // possible values: LOG_DISABLE || LOG_ERROR || LOG_WARN || LOG_INFO || LOG_DEBUG
    logLevel: config.LOG_INFO,


    // enable / disable watching file and executing tests whenever any file changes
    autoWatch: false,


    // Start these browsers, currently available:
    // - Chrome
    // - ChromeCanary
    // - Firefox
    // - Opera
    // - Safari (only Mac)
    // - PhantomJS
    // - IE (only Windows)
    browsers: ['PhantomJS'],


    // Continuous Integration mode
    // if true, it capture browsers, run tests and exit
    singleRun: false
  });
};
