const boardTitle = document.querySelector("#board-title")
const maxIdxBoard = document.querySelector("#max-idx-board")
const clickBoard = document.querySelector("#click-board")
function hide() {
  maxIdxBoard.classList.add("hidden")
}
boardTitle.addEventListener('onClick', hide);