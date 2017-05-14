// jQuery to collapse the navbar on scroll
function collapseNavbar() {
    if ($(".navbar").offset().top > 50) {
        $(".navbar-fixed-top").addClass("top-nav-collapse");
    } else {
        $(".navbar-fixed-top").removeClass("top-nav-collapse");
    }
}

$(window).scroll(collapseNavbar);
$(document).ready(collapseNavbar);

// handler menu click
$(function () {
    $('a.page-scroll').bind('click', function () {
        var $anchor = $(this);
        scrollTo($anchor.attr('href'));
    });
});

// Closes the Responsive Menu on Menu Item Click
$('.navbar-collapse ul li a').click(function () {
    $(".navbar-collapse").collapse('hide');
});


//Post date handler
$(document).ready(function () {
    var url = window.location;
    // SUBMIT FORM
    $("#dateForm").submit(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPost();
    });

    function ajaxPost() {
        var stringDate = $("#date").val();
        if (!isValidDate(stringDate)) {
            alert("Sorry, the inputted date is incorrect . The right format of date is dd/mm.");
            return;
        }

        var date = stringDate.split('/');
        // PREPARE FORM DATA
        var formData = {
            day: Number(date[0]),
            month: Number(date[1])
        };

        // DO POST
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: url + "/zodiacSign",
            data: JSON.stringify(formData),
            success: function (result) {
                if (result.status === "DONE") {
                    var sign = result.zodiacSign.toLowerCase();
                    scrollTo('#' + sign);
                } else {
                    alert("Sorry, there is an error on the server, please reload the page!");
                }
                console.log(result);
            },
            error: function (e) {
                alert("Error!");
                console.log("ERROR: ", e);
            }
        });
    }
});

//scroll to href element
function scrollTo(href) {
    $('html, body').stop().animate({
        scrollTop: $(href).offset().top
    }, 1500, 'easeInOutExpo');
    event.preventDefault();
}


// Validates that the input string is a valid date formatted as "dd/mm"
function isValidDate(dateString) {
    // First check for the pattern
    if (!/^\d{1,2}\/\d{1,2}$/.test(dateString))
        return false;

    // Parse the date parts to integers
    var parts = dateString.split("/");
    var day = parseInt(parts[0], 10);
    var month = parseInt(parts[1], 10);

    // Check the ranges of month and year
    if (month <= 0 || month > 12)
        return false;

    var monthLength = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

    // Check the range of the day
    return day > 0 && day <= monthLength[month - 1];
}
