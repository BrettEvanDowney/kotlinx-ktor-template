$scssSource = './src/com/github/brettevandowney/youtubedlhelper/web/css/scss/main.scss'
$scssBuildDirectory = 'resources/static/styles/csscompiled/main.css'
$buildTS = 'tsc'
$buildSCSS = 'sass $scssSource $scssBuildDirectory'
iex $buildTS
iex $buildSCSS