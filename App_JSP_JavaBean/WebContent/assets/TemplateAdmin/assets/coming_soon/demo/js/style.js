/**
 * CONFIGURATION START
 * EDIT VALUES BELOW THIS LINE
 */

// This option specifies the date at which the counter should stop.
// The counter values (days, minutes etc.) are calculated based on that target date, and the current date.
// The value should be in the format m d Y, H:i:s (see http://www.w3schools.com/js/js_obj_date.asp)
// For example, 21st of January 2013 at 15:04:59 would be: "January 21 2013, 15:04:59"
var stop = "February 28 2014, 00:00:01";

// The date at which the counter began, same format as $stop
var start = "December 21 2012, 00:00:00";

/**
 * CONFIGURATION END
 * DO NOT EDIT ANYTHING BELOW THIS LINE
 */
// Calculate current counter value
var diff    = Math.round((new Date(stop) - new Date()) / 1000);
var days    = Math.floor(diff / 86400);
var hours   = Math.floor((diff -= days * 86400) / 3600);
var minutes = Math.floor((diff -= hours * 3600) / 60);
var seconds = diff - minutes * 60;

// Calculate counter life
var allDiff    = Math.round((new Date(stop) - new Date(start)) / 1000);
var allDays    = Math.floor(allDiff / 86400);

// Initial values
$('#count-seconds').attr('data-value', seconds);
$('#count-minutes').attr('data-value', minutes);
$('#count-hours').attr('data-value', hours);
$('#count-days').attr('data-value', days);

// Set numbers & animate circle
function setNumber(e, v, a, f) {
    e.html('');
    for(var i = 0; i < v.toString().length; i++) {
        e.append('<span class="number n' + v.toString().substring(i, i + 1) + '"></span>');
    }
    var o  = parseInt(e.attr('data-value'));
    var lr = e.parents('.circle').find('.left, .right');
    var l  = e.parents('.circle').find('.left');
    var r  = e.parents('.circle').find('.right');
    if (o != v || f) {
        lr.css({
            'animation-duration': a + 's',
            'animation-delay': (v - a + 1) + 's',
            'animation-play-state': 'running'
        });
        if (v == 0) {
            l.removeClass('left');
            r.removeClass('right');
            setTimeout(function() {
                l.addClass('left');
                r.addClass('right');
            }, 1);
        }
        e.attr('data-value', v);
        setTimeout(function() {
            lr.css('animation-play-state', 'paused');
        }, 1000);
    }
}

// Clock tick
function tick(first) {
    var days    = parseInt($('#count-days').attr('data-value'));
    var hours   = parseInt($('#count-hours').attr('data-value'));
    var minutes = parseInt($('#count-minutes').attr('data-value'));
    var seconds = parseInt($('#count-seconds').attr('data-value'));
    
    if (days <= -1) {
        alert('We should be ready now, refresh the page!');
        return false;
    }
    
    seconds--;
    if (seconds == -1) {
        seconds = 59;
        minutes--;
        if (minutes == -1) {
            minutes = 59;
            hours--;
            if (hours == -1) {
                hours = 23;
                days--;
                if (days == -1) {
                    alert('We should be ready now, refresh the page!');
                    return false;
                }
            }
        }
    }
    
    setNumber($('#count-seconds'), seconds, 60, first);
    setNumber($('#count-minutes'), minutes, 60, first);
    setNumber($('#count-hours'), hours, 24, first);
    setNumber($('#count-days'), days, allDays, first);
    setTimeout(function() { tick(false); }, 1000);
}

// Start ticking
tick(true);