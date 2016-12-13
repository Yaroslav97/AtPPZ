$(document).on('click', '.spinbox-up, .spinbox-down', function () {
    var $spinbox = $(this).closest('.spinbox');
    if ($spinbox.length) {
        var $input = $spinbox.find('input.spinbox-input');
        if ($input.length) {
            var max = parseInt($spinbox.data('max')) || false;
            var min = parseInt($spinbox.data('min')) || false;
            var val = parseInt($input.val()) || min || 0;
            var sign = $(this).hasClass('spinbox-up') ? 1 : -1;
            val += sign * (parseInt($spinbox.data('step')) || 1);
            if (max && val > max) {
                val = max;
            } else if (min && val < min) {
                val = min;
            }
            $input.val(val).trigger('change');
        }
    }
});

$('.spinbox-input').on('change', function () {
    console.log('Spinbox value has been changed!')
});