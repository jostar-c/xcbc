<template>
  <div>
    <h1 class="tle">人民币大小写转换</h1>
    <div class="btn">
      <img
        src="../static/btn.png"
        @click="change()"
        style="width: 64px; height: auto"
        alt=""
      />
    </div>
    <div class="input">
      <tr>
        <td>
          <textarea style="overflow: hidden" v-model="datain"></textarea>
        </td>
      </tr>
    </div>

    <div class="output">
      <tr>
        <td>
          <textarea style="overflow: hidden" v-model="dataout"></textarea>
        </td>
      </tr>
    </div>

    <!--     
    <img class="btn" src="button.png" width=42px height=auto /> -->

    <div class="tab">
      <p class="t">阿拉伯数字与中文大写数字对应表</p>
      <br />
      <table style="border: 0px; width: 1100px; height: 100px; align: center">
        <tr>
          <th style="background-color: #f1b8f1">1</th>
          <th style="background-color: #d9b8f1">2</th>
          <th style="background-color: #b8f1ed">3</th>
          <th style="background-color: #b8f1cc">4</th>
          <th style="background-color: #ddff95">5</th>
          <th style="background-color: #ffe647">6</th>
          <th style="background-color: #ff9b6a">7</th>
          <th style="background-color: #fd803a">8</th>
          <th style="background-color: #f15536">9</th>
          <th style="background-color: #ef5767">0</th>
        </tr>
        <tr>
          <td style="align: center">壹</td>
          <td style="align: center">贰</td>
          <td style="align: center">叁</td>
          <td style="align: center">肆</td>
          <td style="align: center">伍</td>
          <td style="align: center">陆</td>
          <td style="align: center">柒</td>
          <td style="align: center">捌</td>
          <td style="align: center">玖</td>
          <td style="align: center">零</td>
        </tr>
      </table>

      <div class="last">
        <div id="down">
          在财务工作中，数字大小写转换经常困扰着工作人员，本人民币大小写转换工具可以轻松进行数字大小写转换，小巧绿色且便于使用，为您减轻工作烦恼
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      datain: "输入",
      dataout: "输出",
    };
  },
  methods: {
    change() {
      var _this = this;
      this.$axios
        .post("http://192.168.31.149:8084/test/translate", {
          data: _this.datain,
        })
        .then(function (response) {
          console.log(response);
          _this.dataout = response.data;
        })
        .catch((err) => {
          console.log(this.datain + " post失败");
          console.log(err);
        });
    },
  },
};
</script>


<style>
@font-face {
  font-family: "one";
  font-weight: 400;
  src: url("one/one.woff2") format("woff2"), url("one/one.woff") format("woff");
}
@font-face {
  font-family: "two";
  font-weight: 400;
  src: url("two/two.woff2") format("woff2"), url("two/two.woff") format("woff");
}
* {
  padding: 0;
  margin: 0;
}
.tle {
  margin-left: 80px;
  margin-top: 60px;
  font-family: one;
}
.input textarea {
  float: left;
  background-color: rgb(255, 255, 255);
  width: 550px;
  height: 300px;
  margin-top: 40px;
  margin-left: 150px;
  border-radius: 10px 0px 0px 10px;
  position: absolute;
  font-size: 40px;
  color: rgba(137, 137, 137, 0.954);
}
.output textarea {
  float: left;
  background-color: rgb(225, 248, 255);
  width: 550px;
  height: 300px;
  margin-top: 40px;
  margin-left: 700px;
  border-radius: 0px 10px 10px 0px;
  position: absolute;
  font-size: 40px;
  color: rgba(137, 137, 137, 0.954);
}

.button {
  width: 50px;
  height: auto;
  padding: 10px;
  border-radius: 50%;
  font-size: 30px;
  color: rgb(255, 255, 255);
  margin-top: 40px;
  margin-left: 150px;
}
.tab {
  margin-top: 350px;
  margin-left: 150px;
}
.tab p {
  font-size: 20px;
}
.last p {
  margin-top: 50px;
  width: 1100px;
  font-size: 32px;
  color: rgb(197, 199, 199);
}
.btn {
  margin-left: 670px;
  margin-top: 20px;
}
#down {
  margin-top: 30px;
  width: 1100px;
  height: auto;
  text-align: center;
  color: rgb(140, 140, 140);
}
.t {
  color: rgb(92, 92, 92);
}
</style>