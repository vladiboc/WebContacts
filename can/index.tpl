<form name=graf_parameters action="index" method="post">
    <fieldset>
        <legend>Пара:</legend>
        <select name="para"><?php
            foreach ( $tables as $pair) {
                echo PHP_EOL.'        <option value="'.$pair.'"';
                if ( $sel_para == $pair ) echo ' selected'; 
                echo '>'.$pair.'</option>';
            }
        ?>   
        </select>
    </fieldset>
    <fieldset>
        <legend>Период:</legend>
        <input type="date" name="date_start" />
        <input type="date" name="date_stop" />
    </fieldset>
    <fieldset>
        <legend>Рамка времени:</legend>
        <label for="timeframe">Минуты: </label>
        <input id="timeframe" type="text" name="timeframe" value="<?=$sel_timeframe?>" />
    </fieldset>
    <fieldset>
        <legend>Простая средняя:</legend>
        <label for="sma_yellow">Долгосрочная: </label>
        <input id="sma_yellow" type="text" name="sma_yellow" value="200" />
    </fieldset>
    <fieldset>
        <legend>МАКД:</legend>
        <label for="ema_red">Быстр: </label>
        <input id="ema_red" type="text" name="ema_red" value="12" />
        <label for="ema_blue">Медл: </label>
        <input id="ema_blue" type="text" name="ema_blue" value="26" />
        <label for="sma_green">Сглаж: </label>
        <input id="sma_green" type="text" name="sma_green" value="9" />
    </fieldset>
    <fieldset>
        <legend>Стохастик:</legend>
        <label>%K: </label>
        <input type="text" name="sto_raw" value="5" />
        <input type="text" name="sto_K" value="3" />
        <label>%D: </label>
        <input type="text" name="sto_D" value="3" />
    </fieldset>
    <fieldset>
        <legend>Объем:</legend>
        <input type="radio" name="volume" value="1" />Просто
        <input type="radio" name="volume" value="2" checked="checked" />Цвет
        <input type="radio" name="volume" value="3" />Нет
    </fieldset>
    <fieldset>
        <legend>Пуск:</legend>
        <input type="submit" name="graf_parameters" value="Отрисовать" />
    </fieldset>
</form>

<div id="zerofloat"></div>

<div id="graf">
    <img src="<?=$graf_candle_image?>" alt="Картинка свечного графика" title="Свечи" />
</div>

<script type="text/javascript">
    var graf = document.getElementById("graf");
    graf.scrollLeft = graf.scrollWidth;
</script>

<div class="item"></div>

<script type="text/javascript">
    var item = document.querySelector(".item");
    graf.onmousemove = function (e){
        item.style.position = 'fixed';
        item.style.left = e.clientX + -10 + "px";
        item.style.top = e.clientY + -10 + "px";
    }
</script>
