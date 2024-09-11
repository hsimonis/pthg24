all: scheduling.pdf

scheduling.pdf: scheduling.tex exports/title.tex
	rm -f scheduling.pdf
	lualatex --interaction=nonstopmode scheduling
	bibtex scheduling
	lualatex --interaction=nonstopmode scheduling
	lualatex --interaction=nonstopmode scheduling
	lualatex --interaction=nonstopmode scheduling

clean:
	rm -f scheduling.pdf
