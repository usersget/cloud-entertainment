<template>
	<div class="img-box">
		<img ref="imgRef" :class="{ rotate: playStatus }" src="https://storage.beta.custouch.com/res/8082/stopMusic.png"
			alt="music" @click="controlMusic" />
		<audio ref="audioRef" :src="musicUrl" loop></audio>
	</div>
</template>
<script lang="ts" setup>
import { ref } from 'vue'
const audioRef = ref<null | HTMLAudioElement>(null)
const imgRef = ref<null | HTMLImageElement>(null)
let playStatus = ref(false)
defineProps<{
	musicUrl:string
}>()
const musicImg = ref({
	play: 'https://storage.beta.custouch.com/res/8080/music.png',
	pause: 'https://storage.beta.custouch.com/res/8082/stopMusic.png'
})
// const musicUrl = 'https://storage.beta.custouch.com/res/audios/38/bgmusic.mp3'
const controlMusic = () => {
	if (audioRef.value && imgRef.value) {
		if (playStatus.value) {
			audioRef.value.pause()
			imgRef.value.src = musicImg.value['pause']
		} else {
			audioRef.value.play()
			imgRef.value.src = musicImg.value['play']
		}
	}
	playStatus.value = !playStatus.value
}
</script>
<style scoped lang="less">
// 元素持续旋转关键帧
@keyframes rotation {
	from {
		transform: rotate(0deg);
	}

	to {
		transform: rotate(360deg);
	}
}

.img-box {
	width: 27px;
	height: 27px;

	img {
		width: 100%;
		height: 100%;
	}
}

// 旋转类
.rotate {
	animation: rotation 3s linear infinite;
}
</style>