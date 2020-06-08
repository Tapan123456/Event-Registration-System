
           /*============================================
      ISOTOP GALLERY
    ==============================================*/
    var isotopeContainer = $('.isotopeContainer');
    var isotopeFilters = $('.isotopeFilters');
    if (isotopeContainer.length) {
        $(window).on('load', function () {
            isotopeContainer.isotope({
                itemSelector: '.isotopeSelector'
            });
            isotopeFilters.on('click', 'a', function (e) {
                isotopeFilters.find('.active').removeClass('active');
                $(this).parent().addClass('active');
                var filterValue = $(this).attr('data-filter');
                isotopeContainer.isotope({
                    filter: filterValue
                });
                e.preventDefault();
            });
        });

    }

