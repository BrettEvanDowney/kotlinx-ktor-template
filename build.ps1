$scssSource = './src/com/github/brettevandowney/template/web/css/scss/main.scss'
$scssBuildDirectory = 'resources/static/styles/csscompiled/main.css'
$buildTS = 'tsc'
$buildSCSS = 'sass $scssSource $scssBuildDirectory'
iex $buildTS
iex $buildSCSS