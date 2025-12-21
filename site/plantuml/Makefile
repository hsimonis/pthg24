all: description.pdf

description.pdf: description.tex compact.png classes.png full.png Acronym.png Affiliation.png ApplicationDataset.png ApplicationDifference.png ApplicationObject.png ApplicationWarning.png Article.png Assertion.png Author.png AuthorDouble.png Authorship.png Book.png Citation.png Coauthor.png CollabCount.png CollabWork.png Collection.png Concept.png ConceptType.png ConceptWork.png ConferenceSeries.png ConnectedComponent.png CountryCollab.png CrossReference.png DoiReference.png Edge.png InBook.png InCollection.png Journal.png JournalAlias.png Link.png MissingCitedWork.png MissingCitingWork.png MissingCross.png MissingWork.png Node.png Orphan.png OtherWork.png Paper.png PhDThesis.png Proceedings.png Publisher.png Reference.png ReferenceFlow.png Scenario.png School.png ScopusAffiliation.png ScopusCity.png ScopusCountry.png Similarity.png SourceGroup.png SpecialIssue.png Translator.png UncategorizedReference.png Work.png WorkAffiliation.png
	pdflatex description
	pdflatex description
	pdflatex description

%.png:%.txt
	java -jar plantuml-1.2024.7.jar $<

clean:
	rm -f *.png *.pdf

