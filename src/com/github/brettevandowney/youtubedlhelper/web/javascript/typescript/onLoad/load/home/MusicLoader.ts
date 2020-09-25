/**
 * A loadable module which initializes the scripts required
 * to handle load music when entering the default home page.
 */
class MusicLoader extends Loadable {

    /**
     * Upon page load, load the music and then play instead of
     * having an audio element.
     */
    load() {
        // noinspection JSUnresolvedVariable
        // @ts-ignore
        let audioCtx = new (window.AudioContext || window.webkitAudioContext)();
        let xhr = new XMLHttpRequest();
        xhr.open('GET', '/static/ivantorrent.mp3');
        xhr.responseType = 'arraybuffer';
        xhr.addEventListener('load', () => {
            let playsound = (audioBuffer: any) => {
                let source = audioCtx.createBufferSource();
                source.buffer = audioBuffer;
                source.connect(audioCtx.destination);
                source.loop = false;
                source.start();
            };

            audioCtx.decodeAudioData(xhr.response).then(playsound);
        });
        xhr.send();
    }
}